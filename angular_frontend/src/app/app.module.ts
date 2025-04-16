import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FarmerListComponent } from './farmer-list/farmer-list.component';
import { HttpClientModule } from '@angular/common/http';
import { CreateFarmerComponent } from './create-farmer/create-farmer.component';
import { UpdateFarmerComponent } from './update-farmer/update-farmer.component';
import { FarmerDetailsComponent } from './farmer-details/farmer-details.component';
import { FileUploadComponent } from './file-upload/file-upload.component';

@NgModule({
  declarations: [
    AppComponent,
    FarmerListComponent,
    CreateFarmerComponent,
    UpdateFarmerComponent,
    FarmerDetailsComponent,
    FileUploadComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
