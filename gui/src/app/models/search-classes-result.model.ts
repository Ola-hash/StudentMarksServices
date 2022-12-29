import {LecturerModel} from "./lecturer.model";
import {SemesterModel} from "./semester.model";

export interface SearchClassesResultModel {
  classesId: number;
  subjectName: String;
  courseName: String;
  type: String;
  courseDate: String;
  lecturerDTO: LecturerModel;
  semesterDTO: SemesterModel;
  numberOfStudents: number;
}
