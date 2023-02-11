import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WomenComponent } from './components/women/women.component';
import { ShoesComponent } from './components/shoes/shoes.component';
import { HandbagsComponent } from './components/handbags/handbags.component';
import { JewelleryComponent } from './components/jewellery/jewellery.component';
import { MenComponent } from './components/men/men.component';
import { KidsComponent } from './components/kids/kids.component';
import { HomeComponent } from './components/home/home.component';
import { SaleComponent } from './components/sale/sale.component';
import { DesignersComponent } from './components/designers/designers.component';
import { EditorialComponent } from './components/editorial/editorial.component';
import { GiftsComponent } from './components/gifts/gifts.component';
import { DWomenComponent } from './components/d-women/d-women.component';
import { DHandbagsComponent } from './components/d-handbags/d-handbags.component';
import { DShoesComponent } from './components/d-shoes/d-shoes.component';
import { DJewelleryComponent } from './components/d-jewellery/d-jewellery.component';
import { DMenComponent } from './components/d-men/d-men.component';
import { DKidsComponent } from './components/d-kids/d-kids.component';
import { DHomeComponent } from './components/d-home/d-home.component';
import { DAllComponent } from './components/d-all/d-all.component';
import { MainComponent } from './components/main/main.component';
import { UserComponent } from './components/user/user.component';
import { AdminComponent } from './components/admin/admin.component';

@NgModule({
  declarations: [
    AppComponent,
    WomenComponent,
    ShoesComponent,
    HandbagsComponent,
    JewelleryComponent,
    MenComponent,
    KidsComponent,
    HomeComponent,
    SaleComponent,
    DesignersComponent,
    EditorialComponent,
    GiftsComponent,
    DWomenComponent,
    DHandbagsComponent,
    DShoesComponent,
    DJewelleryComponent,
    DMenComponent,
    DKidsComponent,
    DHomeComponent,
    DAllComponent,
    MainComponent,
    UserComponent,
    AdminComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
