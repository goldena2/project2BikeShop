import { AboutComponent } from './about/about.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FrontPageComponent } from './front-page/front-page.component';
import { MakeCustomerAcountComponent } from './make-customer-acount/make-customer-acount.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
//inserting product add button - Patrick
import { ProductComponent } from './product/product.component'

const routes: Routes = [
  {path:'', component: FrontPageComponent},
  {path: 'makeAcount', component: MakeCustomerAcountComponent},
  {path: 'about', component: AboutComponent},
  //inserting product add button - Patrick
  {path: 'products', component: ProductComponent},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
