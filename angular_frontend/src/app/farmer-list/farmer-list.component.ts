import { Component, OnInit } from '@angular/core';
import { Farmer } from '../farmer';
import { FarmerService } from '../farmer.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-farmer-list',
  standalone: false,
  templateUrl: './farmer-list.component.html',
  styleUrl: './farmer-list.component.css',
})
export class FarmerListComponent implements OnInit {
  farmers: Farmer[] = [];

  constructor(private farmerService: FarmerService, private router: Router) {}
  ngOnInit(): void {
    this.getFarmers();
  }

  private getFarmers() {
    this.farmerService.getFarmerList().subscribe((data) => {
      this.farmers = data;
    });
  }

  farmerDetails(id: number) {
    this.router.navigate(['farmer-details', id]);
  }
  updateFarmer(id: number) {
    this.router.navigate(['update-farmer', id]);
  }

  deleteFarmer(id: number): void {
    this.farmerService.deleteFarmer(id).subscribe(() => {
      this.farmers = this.farmers.filter((f) => f.id !== id);
    });
  }

  downloadExcel(): void {
    window.open('http://localhost:8081/api/farmers/export', '_blank');
  }
}