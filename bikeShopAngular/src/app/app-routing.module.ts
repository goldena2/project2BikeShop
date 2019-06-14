import { MyServicesComponent } from './my-services/my-services.component';
import { ScheduleServiceComponent } from './schedule-service/schedule-service.component';
import { AllProductsComponent } from './all-products/all-products.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FrontPageComponent } from './front-page/front-page.component';
import { MakeCustomerAcountComponent } from './make-customer-acount/make-customer-acount.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { ProductComponent } from './product/product.component';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';

const routes: Routes = [
  {path:'', component: FrontPageComponent},
  {path: 'scheduleService', component: ScheduleServiceComponent},
  {path: 'makeAcount', component: MakeCustomerAcountComponent},
  {path: 'about', component: AboutComponent},
  {path: 'home', component: HomeComponent},
  {path: 'allProducts', component: AllProductsComponent},
  {path: 'products', component: ProductComponent},
  {path: 'myServices', component: MyServicesComponent},
  {path: 'createEmployee', component: CreateEmployeeComponent},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
