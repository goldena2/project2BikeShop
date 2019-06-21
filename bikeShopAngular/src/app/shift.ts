import { Day } from './day';
import { User } from './user';

export class Shift {
    id: number;
    scheduleId: number;
    user: User;
    startTime: number;
    endTime: number;
    public day: Day;
}