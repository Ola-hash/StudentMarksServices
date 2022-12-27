import {Component, OnInit} from '@angular/core';
import {CourseService} from "../../services/course.service";
import {ClassesService} from "../../services/classes.service";
import {ToastrService} from "ngx-toastr";
import {ClassesListFormService} from "../../services/classes-list-form.service";
import {SubjectService} from "../../services/subject.service";
import {SemesterService} from "../../services/semester.service";
import {ActivatedRoute, Router} from "@angular/router";
import {ClassesModel} from "../../models/classes.model";
import {SearchClassesResultModel} from "../../models/search-classes-result.model";

@Component({
  selector: 'app-classes-list',
  templateUrl: './classes-list.component.html',
  styleUrls: ['./classes-list.component.scss']
})
export class ClassesListComponent implements OnInit {

  public id: number;
  public searchClassesResultModels: SearchClassesResultModel[];
  public readonly displayedColumns: string[] = ['subjectName', 'courseName', 'lecturer', 'type', 'courseDate',
    'courseRoom', 'numberOfStudents', 'addStudent'];

  constructor(private readonly classesService: ClassesService,
              private readonly toastrService: ToastrService,
              private readonly classesListFormService: ClassesListFormService,
              private readonly subjectService: SubjectService,
              private readonly courseService: CourseService,
              private readonly semesterService: SemesterService,
              private readonly router: Router,
              private readonly route: ActivatedRoute) {
  }

  ngOnInit(): void {
    const idParam: string = this.route.snapshot.paramMap.get('lecturerId');
    if (idParam.match("^[\\d]+$")) {
      this.id = parseInt(idParam, 10);
      this.classesService.getClassesByLecturerId(this.id).subscribe(response => this.searchClassesResultModels = response,
        error => this.toastrService.error(error.error.message));
    }
  }

  public navigateToStudentClasses(id: number) {
    this.router.navigate(['classes-student-list/' + id]).then();
  }


}
