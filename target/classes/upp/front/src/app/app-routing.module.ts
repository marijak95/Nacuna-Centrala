import { RegistrationComponent } from './registration/registration.component';
import { ThesesComponent } from './theses/theses.component';
import { AuthorsThesesComponent } from './authors-theses/authors-theses.component';
import { LoginComponent } from './login/login.component';
import { NgModule, Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { TasksComponent } from './tasks/tasks.component';
import { ReviewerCommentsComponent } from './reviewer-comments/reviewer-comments.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: '', component: LoginComponent },
   { path: 'registration', component: RegistrationComponent },
   { path: 'login/registration', component: RegistrationComponent },
  { path: 'tasks', component: TasksComponent},
  { path: 'authors-theses', component: AuthorsThesesComponent},
  { path: 'theses', component: ThesesComponent},
  { path: 'reviewer-comments/:thesisId', component: ReviewerCommentsComponent}
]

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule],
  declarations: []
})

export class AppRoutingModule { }