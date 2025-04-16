import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FarmerListComponent } from './farmer-list/farmer-list.component';
import path from 'node:path';
import { CreateFarmerComponent } from './create-farmer/create-farmer.component';
import { UpdateFarmerComponent } from './update-farmer/update-farmer.component';
import { FarmerDetailsComponent } from './farmer-details/farmer-details.component';
import { FileUploadComponent } from './file-upload/file-upload.component';

const routes: Routes = [
  { path: 'farmers', component: FarmerListComponent },
  { path: 'create-farmer', component: CreateFarmerComponent },
  { path: 'upload-file', component: FileUploadComponent },
  { path: 'update-farmer/:id', component: UpdateFarmerComponent },
  { path: '', redirectTo: 'farmers', pathMatch: 'full' },
  { path: 'farmer-details/:id', component: FarmerDetailsComponent },
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
