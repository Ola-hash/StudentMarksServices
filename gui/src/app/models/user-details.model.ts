import {PrivilegeModel} from './privilege.model';

export interface UserDetailsModel {
  id: number
  lecturerId?: number
  sessionValue: string
  privileges: PrivilegeModel[];
}
