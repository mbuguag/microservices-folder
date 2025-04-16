import { Component, OnInit } from '@angular/core';
import { Farmer } from '../farmer';
import { FarmerService } from '../farmer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-farmer',
  standalone: false,
  templateUrl: './create-farmer.component.html',
  styleUrls: ['./create-farmer.component.css'],
})
export class CreateFarmerComponent implements OnInit {
  farmer: Farmer = new Farmer();

  constructor(private farmerService: FarmerService, private router: Router) {}

  ngOnInit(): void {}

  saveFarmer() {
    console.log('Calling createFarmer API with:', this.farmer);
    this.farmerService.createFarmer(this.farmer).subscribe({
      next: (data) => {
        console.log('Farmer created successfully:', data);
        this.goToFarmerList();
      },
      error: (err) => console.error('Error creating farmer:', err),
    });
  }

  goToFarmerList() {
    this.router.navigate(['/farmers']);
  }

  onSubmit() {
    console.log('Submitting farmer:', this.farmer);
    this.saveFarmer();
  }
}
