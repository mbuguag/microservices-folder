import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Farmer } from './farmer';

@Injectable({
  providedIn: 'root',
})
export class FarmerService {
  private baseUrl = 'http://localhost:8081/api/farmers';

  constructor(private http: HttpClient) {} // ✅ Correct Injection

  getFarmerList(): Observable<Farmer[]> {
    return this.http.get<Farmer[]>(`${this.baseUrl}`);
  }

  createFarmer(farmer: Farmer): Observable<Farmer> {
    return this.http.post<Farmer>(`${this.baseUrl}`, farmer); // ✅ Fixed Here
  }

  getFarmerById(id: number): Observable<Farmer> {
    return this.http.get<Farmer>(`${this.baseUrl}/${id}`);
  }

  updateFarmer(id: number, farmer: Farmer): Observable<object> {
    return this.http.put(`${this.baseUrl}/${id}`, farmer);
  }

  deleteFarmer(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
