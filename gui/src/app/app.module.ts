import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {CreateStudentComponent} from './pages/create-student/create-student.component';
import {AppRoutingModule} from "./app.routing.module";
import {ReactiveFormsModule} from "@angular/forms";
import {StudentFormService} from "./services/student-form.service";
import {StudentService} from "./services/student.service";
import {HttpClientModule} from "@angular/common/http";
import {MatInputModule} from "@angular/material/input";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatButtonModule} from "@angular/material/button";
import {ToastrModule} from "ngx-toastr";
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {MatOptionModule} from "@angular/material/core";
import {MatSelectModule} from "@angular/material/select";
import {CreateAcademicYearComponent} from "./pages/create-academic-year/create-academic-year.component";
import {AcademicYearService} from "./services/academic-year.service";
import {AcademicYearFormService} from "./services/academic-year-form-service";
import {CreateSubjectComponent} from "./pages/create-subject/create-subject.component";
import {SubjectFormService} from "./services/subject-form.service";
import {SubjectService} from "./services/subject.service";
import {CreateCourseComponent} from "./pages/create-course/create-course.component";
import {CourseFormService} from "./services/course-form.service";
import {CourseService} from "./services/course.service";
import {StudentListComponent} from "./pages/student-list/student-list.component";
import {StudentListFormService} from "./services/student-list-form.service";
import {MatTableModule} from "@angular/material/table";
import {EditStudentComponent} from "./pages/edit-student/edit-student.component";
import {LecturerService} from "./services/lecturer.service";
import {CreateLecturerComponent} from "./pages/create-lecturer/create-lecturer.component";
import {LecturerFormService} from "./services/lecturer-form.service";
import {ClassesService} from "./services/classes.service";
import {ClassesFormService} from "./services/classes-form.service";
import {CreateClassesComponent} from "./pages/create-classes/create-classes.component";
import {SemesterService} from "./services/semester.service";
import {ClassesListComponent} from "./pages/classes-list/classes-list.component";
import {ClassesListFormService} from "./services/classes-list-form.service";
import {AddStudentToClassesComponent} from "./pages/add-student-to-classes/add-student-to-classes.component";
import {AddStudentToClassesFormService} from "./services/add-student-to-classes-form.service";
import {ClassesStudentListComponent} from "./pages/classes-student-list/classes-student-list.component";
import {AddMarkToStudentComponent} from "./pages/add-mark-to-student/add-mark-to-student.component";
import {AddMarkToStudentService} from "./services/add-mark-to-student.service";
import {AddMarkToStudentFormService} from "./services/add-mark-to-student-form.service";


@NgModule({
  declarations: [
    AppComponent,
    CreateStudentComponent,
    CreateAcademicYearComponent,
    CreateSubjectComponent,
    CreateCourseComponent,
    StudentListComponent,
    EditStudentComponent,
    CreateLecturerComponent,
    CreateClassesComponent,
    ClassesListComponent,
    AddStudentToClassesComponent,
    ClassesStudentListComponent,
    AddMarkToStudentComponent

  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatInputModule,
    MatButtonModule,
    ToastrModule.forRoot(),
    FontAwesomeModule,
    MatOptionModule,
    MatSelectModule,
    MatTableModule
  ],
  providers: [StudentFormService, StudentService, AcademicYearFormService, AcademicYearService,
    SubjectFormService, SubjectService, CourseFormService, CourseService, StudentListFormService,
    LecturerService, LecturerFormService, ClassesService, ClassesFormService, SemesterService, ClassesListFormService,
    AddStudentToClassesFormService, AddMarkToStudentFormService, AddMarkToStudentService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
