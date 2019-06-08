import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule }   from '@angular/forms';
import { enableProdMode } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegistracijaComponent } from './components/registracija/registracija.component';
import { RegistracijaService } from './services/registracija.service';
import { environment } from 'src/environments/environment';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';

const Routes=[
  {
    path: "home",
    component: RegistracijaComponent
  }
]


if (environment.production) {
  enableProdMode();
}


@NgModule({
  declarations: [
    AppComponent,
    RegistracijaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(Routes)
  ],
  providers: [
    RegistracijaService

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
