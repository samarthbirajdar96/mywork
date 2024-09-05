import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { StudentComponent } from './student.component'

@NgModule({
  declarations: [
    StudentComponent
  ],
  imports: [
    CommonModule,
    FormsModule
  ],
  exports: [
    StudentComponent // Export StudentComponent to use it in other modules
  ]
})
export class StudentModule { }
