export interface LecturerModel {
  lecturerId: number;
  firstName: string;
  lastName: string;
  email: string;
}

export interface CreateLecturerModel {
  firstName: string;
  lastName: string;
  email: string;
  password: string;
}

