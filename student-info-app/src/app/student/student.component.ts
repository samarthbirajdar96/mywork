import { Component } from '@angular/core';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrl: './student.component.css'
})


export class StudentComponent  {

  students: { id: number, name: string }[] = [];
  currentStudent = '';

  constructor() { }

  ngOnInit(): void {
    this.students = [
      { id: 1, name: 'John Doe' },
      { id: 2, name: 'Jane Smith' },
      { id: 3, name: 'Sam Johnson' }
    ];
  }

  addStudent(): void {
    if (this.currentStudent) {
      const newStudent = {
        id: this.students.length + 1,
        name: this.currentStudent
      };
      this.students.push(newStudent);
      this.currentStudent = '';  
    }
  }

  removeStudent(id: number): void {
    this.students = this.students.filter(student => student.id !== id);
  }
}