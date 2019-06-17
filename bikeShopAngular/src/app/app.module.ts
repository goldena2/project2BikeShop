import { MakePurchaseService } from './make-purchase.service';
import { AllProductsService } from './all-products.service';
import { ScheduledServicesService } from './scheduled-services.service';
import { GetUserService } from './get-user.service';
import { LoginService } from './login.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FrontPageComponent } from './front-page/front-page.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { MakeCustomerAcountComponent } from './make-customer-acount/make-customer-acount.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { MakeAccountService } from './make-account.service';
import { HttpClient } from '@angular/common/http';
import { FooterComponent } from './footer/footer.component';
import { AboutComponent } from './about/about.component';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { ScheduleServiceComponent } from './schedule-service/schedule-service.component';
import { AllProductsComponent } from './all-products/all-products.component';
import { AddProductComponent } from './add-product/add-product.component';
import { MyServicesComponent } from './my-services/my-services.component';
import { MyServivesService } from './my-servives.service';
import { ProductListElementComponent } from './product-list-element/product-list-element.component';
import { RemoveProductComponent } from './remove-product/remove-product.component';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductComponent } from './product/product.component';
import { AllSchedulesComponent } from './all-schedules/all-schedules.component';
import { ScheduleListComponent } from './schedule-list/schedule-list.component';
import { ScheduleListElementComponent } from './schedule-list-element/schedule-list-element.component';



@NgModule({
  declarations: [
    AppComponent,
    FrontPageComponent,
    NavBarComponent,
    MakeCustomerAcountComponent,
    PageNotFoundComponent,
    FooterComponent,
    AboutComponent,
    HomeComponent,
    ScheduleServiceComponent,
    AllProductsComponent,
    AddProductComponent,
    ProductListElementComponent,
    RemoveProductComponent,
    ProductComponent,
    MyServicesComponent,
    ProductListElementComponent,
    ProductComponent,
    CreateEmployeeComponent,
    ProductListComponent,
    AllSchedulesComponent,
    ScheduleListComponent,
    ScheduleListElementComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [MakeAccountService, 
    HttpClient, 
    GetUserService, 
    LoginService, 
    ScheduledServicesService, 
    MyServivesService,
    AllProductsService,
    MakePurchaseService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
  currUser : object;

 }
