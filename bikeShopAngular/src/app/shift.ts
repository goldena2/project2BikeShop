import { Day } from './day';

export class Shift {
    id: number;
    scheduleId: number;
    userId: number;
    startTime: number;
    endTime: number;
    public day: Day;
}