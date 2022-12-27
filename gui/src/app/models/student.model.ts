export interface StudentModel {
  studentId: number;
  index: string;
  firstName: string;
  lastName: string;
  email: string;
  subjectId: number;
  subjectName: string;
}

export interface SearchStudentsResult {
  firstName: string;
  lastName: string;
  email: string;
}

export interface StudentMarkModel{
  studentId:number;

}


