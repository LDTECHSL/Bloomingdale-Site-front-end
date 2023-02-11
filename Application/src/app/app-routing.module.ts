import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {WomenComponent} from "./components/women/women.component";
import {ShoesComponent} from "./components/shoes/shoes.component";
import {HandbagsComponent} from "./components/handbags/handbags.component";
import {SaleComponent} from "./components/sale/sale.component";
import {MenComponent} from "./components/men/men.component";
import {KidsComponent} from "./components/kids/kids.component";
import {JewelleryComponent} from "./components/jewellery/jewellery.component";
import {HomeComponent} from "./components/home/home.component";
import {DesignersComponent} from "./components/designers/designers.component";
import {EditorialComponent} from "./components/editorial/editorial.component";
import {GiftsComponent} from "./components/gifts/gifts.component";
import {DWomenComponent} from "./components/d-women/d-women.component";
import {NotFoundError} from "rxjs";
import {DShoesComponent} from "./components/d-shoes/d-shoes.component";
import {DHandbagsComponent} from "./components/d-handbags/d-handbags.component";
import {DJewelleryComponent} from "./components/d-jewellery/d-jewellery.component";
import {DMenComponent} from "./components/d-men/d-men.component";
import {DKidsComponent} from "./components/d-kids/d-kids.component";
import {DHomeComponent} from "./components/d-home/d-home.component";
import {DAllComponent} from "./components/d-all/d-all.component";
import {MainComponent} from "./components/main/main.component";
import {UserComponent} from "./components/user/user.component";
import {AdminComponent} from "./components/admin/admin.component";

const routes: Routes = [
  {path:'', redirectTo:'/main', pathMatch:'full'},
  {path:'admin', component: AdminComponent},
  {path:'main', component: UserComponent , children:[
      {path:'', component:MainComponent},
      {path:'women',component: WomenComponent},
      {path:'shoes', component: ShoesComponent},
      {path:'hand_bags', component: HandbagsComponent},
      {path:'sale', component: SaleComponent},
      {path:'men', component: MenComponent},
      {path:'kids', component: KidsComponent},
      {path:'jewellery', component: JewelleryComponent},
      {path:'home', component: HomeComponent},
      {path:'designers', component: DesignersComponent, children:[
          {path:'', component: DAllComponent},
          {path:'d-women', component: DWomenComponent},
          {path:'d-shoes', component: DShoesComponent},
          {path:'d-handbags', component: DHandbagsComponent},
          {path:'d-jewelry', component: DJewelleryComponent},
          {path:'d-men', component: DMenComponent},
          {path:'d-kids', component: DKidsComponent},
          {path:'d-home', component: DHomeComponent},
          {path:'d-all', component: DAllComponent}
        ]},
      {path:'editorial', component: EditorialComponent},
      {path:'gifts', component: GiftsComponent}
    ]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
