import { Component, OnInit } from '@angular/core';
import { Farmer } from '../farmer';
import { FarmerService } from '../farmer.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-farmer',
  standalone: false,
  templateUrl: './update-farmer.component.html',
  styleUrl: './update-farmer.component.css',
})
export class UpdateFarmerComponent implements OnInit {
  // [x: string]: any;
  // onSubmit() {
  // throw new Error('Method not implemented.');
  // }
  // farmer: any;

  id!: number;
  farmer: Farmer = new Farmer();
  constructor(
    private farmerService: FarmerService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.farmerService.getFarmerById(this.id).subscribe(
      (data) => {
        this.farmer = data;
      },
      (error) => console.error(error)
    );
  }
  onSubmit() {
    console.log(this.farmer);
    this.updateFarmer();
  }

  updateFarmer() {
    this.farmerService.updateFarmer(this.id, this.farmer).subscribe(
      (data) => {
        console.log('Farmer updated successfully', data);
        this.router.navigate(['/farmers']); // Redirect to farmer list after update
      },
      (error) => console.error('Error updating farmer:', error)
    );
  }
}
