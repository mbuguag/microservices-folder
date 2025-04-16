import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FarmerService } from '../farmer.service';
import { Farmer } from '../farmer';

@Component({
  selector: 'app-farmer-details',
  standalone: false,
  templateUrl: './farmer-details.component.html',
  styleUrl: './farmer-details.component.css',
})
export class FarmerDetailsComponent  implements OnInit {
  id!: number;
  farmer!: Farmer;

  constructor(
    private route: ActivatedRoute,
    private farmerService: FarmerService
  ) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.farmer = new Farmer();
    this.farmerService.getFarmerById(this.id).subscribe((data) => {
      this.farmer = data;
    });
  }
}
