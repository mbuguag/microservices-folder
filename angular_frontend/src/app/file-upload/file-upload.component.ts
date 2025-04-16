import { Component } from '@angular/core';
import { FileUploadService } from '../services/file-upload.service';

@Component({
  selector: 'app-file-upload',
  standalone: false,
  templateUrl: './file-upload.component.html',
  styleUrls: ['./file-upload.component.css'],
})
export class FileUploadComponent {
  selectedFile: File | null = null;
  uploadMessage: string = '';

  constructor(private fileUploadService: FileUploadService) {}

  onFileSelected(event: any): void {
    this.selectedFile = event.target.files[0];
  }

  uploadFile(): void {
    if (!this.selectedFile) {
      this.uploadMessage = 'Please select a file first.';
      return;
    }

    const formData = new FormData();
    formData.append('file', this.selectedFile);

    this.fileUploadService.uploadFile(formData).subscribe({
      next: (response) => (this.uploadMessage = 'Upload successful!'),
      error: (err) => (this.uploadMessage = `Upload failed: ${err.error}`),
    });
  }
}
