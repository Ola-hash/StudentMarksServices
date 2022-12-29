import {Component, OnInit} from '@angular/core';
import {StudentModel} from "../../models/student.model";
import {ActivatedRoute, Router} from "@angular/router";
import {ClassesService} from "../../services/classes.service";
import {StudentService} from "../../services/student.service";
import {ToastrService} from "ngx-toastr";
import {ClassesModel} from "../../models/classes.model";
import {SearchClassesResultModel} from "../../models/search-classes-result.model";

@Component({
  selector: 'app-classes-student-list',
  templateUrl: './classes-student-list.component.html',
  styleUrls: ['./classes-student-list.component.scss']
})
export class ClassesStudentListComponent implements OnInit {

  public classesId: number;
  public studentModel: StudentModel[];
  public searchClassesResultModel: SearchClassesResultModel;
  public readonly displayedColumns: string[] = ['index', 'firstName', 'lastName', 'marks', 'addMark'];

  constructor(private readonly router: Router,
              private readonly route: ActivatedRoute,
              private readonly classesService: ClassesService,
              private readonly studentService: StudentService,
              private readonly toastrService: ToastrService
  ) {
  }

  ngOnInit(): void {
    const idParam: string = this.route.snapshot.paramMap.get('classesId');
    if (idParam.match("^[\\d]+$")) {
      this.classesId = parseInt(idParam, 10);
      this.classesService.getClassesDetails(this.classesId).subscribe(responseClassesStudent => this.searchClassesResultModel = responseClassesStudent);
      this.studentService.getStudentsByClassesId(this.classesId).subscribe(response => this.studentModel = response,
        error => this.toastrService.error(error.error.message));
    }
  }

  public navigateToStudent(studentId: number) {
    this.router.navigate(['students-manage/add-mark-to-student/' + this.classesId + "/" + studentId]).then();
  }

}
