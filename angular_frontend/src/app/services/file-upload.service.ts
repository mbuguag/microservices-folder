import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class FileUploadService {
  private uploadUrl = 'http://localhost:8081/api/farmers/upload'; // Ensure backend is running on 8081

  constructor(private http: HttpClient) {}

  uploadFile(fileData: FormData): Observable<any> {
    return this.http.post(this.uploadUrl, fileData, {
      responseType: 'text', // Expecting a text response
    });
  }
}
