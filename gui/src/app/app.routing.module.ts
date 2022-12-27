import {RouterModule, Routes} from "@angular/router";
import {CreateStudentComponent} from "./pages/create-student/create-student.component";
import {NgModule} from "@angular/core";
import {CreateAcademicYearComponent} from "./pages/create-academic-year/create-academic-year.component";
import {CreateSubjectComponent} from "./pages/create-subject/create-subject.component";
import {CreateCourseComponent} from "./pages/create-course/create-course.component";
import {StudentListComponent} from "./pages/student-list/student-list.component";
import {EditStudentComponent} from "./pages/edit-student/edit-student.component";
import {CreateLecturerComponent} from "./pages/create-lecturer/create-lecturer.component";
import {CreateClassesComponent} from "./pages/create-classes/create-classes.component";
import {ClassesListComponent} from "./pages/classes-list/classes-list.component";
import {AddStudentToClassesComponent} from "./pages/add-student-to-classes/add-student-to-classes.component";
import {ClassesStudentListComponent} from "./pages/classes-student-list/classes-student-list.component";
import {AddMarkToStudentComponent} from "./pages/add-mark-to-student/add-mark-to-student.component";

const routes: Routes = [
  {path: 'create-student', component: CreateStudentComponent},
  {path: 'create-academic-year', component: CreateAcademicYearComponent},
  {path: 'create-subject', component: CreateSubjectComponent},
  {path: 'create-course', component: CreateCourseComponent},
  {path: 'students-list', component: StudentListComponent},
  {path: 'edit-student/:id', component: EditStudentComponent},
  {path: 'create-lecturer', component: CreateLecturerComponent},
  {path: 'create-classes', component: CreateClassesComponent},
  {path: 'classes-list/:lecturerId', component: ClassesListComponent},
  {path: 'add-student-to-classes/:id', component: AddStudentToClassesComponent},
  {path: 'classes-student-list/:classesId', component: ClassesStudentListComponent},
  {path: 'add-mark-to-student/:classesId/:studentId', component: AddMarkToStudentComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
