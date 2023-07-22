package iNoby;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimeSlotChecker {
	private LocalTime startTime;
	private LocalTime endTime;

	public TimeSlotChecker() {}

	public TimeSlotChecker(String startTimeString, String endTimeString) {
		LocalTime startTime = LocalTime.parse(startTimeString);
		LocalTime endTime = LocalTime.parse(endTimeString);
		if(!startTime.isBefore(endTime)) {
			throw new IllegalArgumentException("''起始時間''不能晚於或等於''結束時間'' (不支援跨天)");
		} else{
			this.startTime = startTime;
			this.endTime = endTime;
			System.out.println(startTime + ", " + endTime);
		}
	}

	public boolean isOverlappingWith(TimeSlotChecker otherTimeSlot) {	//當其中之一開始與另一結束相同，不視為重疊
		/*
		System.out.println("##########");
		System.out.println(!this.getStart().isAfter(otherTimeSlot.getStart()));
		System.out.println(!this.getEnd().isAfter(otherTimeSlot.getStart()));
		System.out.println("----------");
		System.out.println(!this.getStart().isAfter(otherTimeSlot.getStart()) && !this.getEnd().isAfter(otherTimeSlot.getStart()));
		System.out.println("==========");
		System.out.println(!this.getStart().isBefore(otherTimeSlot.getEnd()));
		System.out.println(!this.getEnd().isBefore(otherTimeSlot.getEnd()));
		System.out.println("----------");
		System.out.println(!this.getStart().isBefore(otherTimeSlot.getEnd()) && !this.getEnd().isBefore(otherTimeSlot.getEnd()));
		System.out.println("%%%%%%%%%%");
		System.out.println((!this.getStart().isAfter(otherTimeSlot.getStart()) && !this.getEnd().isAfter(otherTimeSlot.getStart())) || (!this.getStart().isBefore(otherTimeSlot.getEnd()) && !this.getEnd().isBefore(otherTimeSlot.getEnd())));
		System.out.println("##########");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		*/
		return !( (!this.getStart().isAfter(otherTimeSlot.getStart()) && !this.getEnd().isAfter(otherTimeSlot.getStart())) || (!this.getStart().isBefore(otherTimeSlot.getEnd()) && !this.getEnd().isBefore(otherTimeSlot.getEnd())) );
	}

	public LocalTime getStart() {
		return startTime;
	}

	public LocalTime getEnd() {
		return endTime;
	}

	public boolean checkOverlapping(TimeSlotChecker[] timeSlots) {
		boolean result = false;
		//List<Boolean> resultSet = new ArrayList<>();
		for (int i = 0; i < timeSlots.length; i++) {
			for (int j = i + 1; j < timeSlots.length; j++) {
				if (timeSlots[i].isOverlappingWith(timeSlots[j])) {
					result = true;
					//resultSet.add(true);
				//}else {
					//resultSet.add(false);
				}
			}
		}
		return result;	//回傳為"是否有重疊"，如有回傳true
	}

	public static void main(String[] args) {
		TimeSlotChecker[] overlappedSlots = {
			new TimeSlotChecker("08:00", "11:00"),
			new TimeSlotChecker("10:00", "17:00"),
			new TimeSlotChecker("16:00", "19:00")
		};
		TimeSlotChecker[] notOverlappedSlots = {
			new TimeSlotChecker("08:00", "10:00"),
			new TimeSlotChecker("13:00", "16:00"),
			new TimeSlotChecker("16:00", "19:00"),

		};
		TimeSlotChecker timeSlotChecker = new TimeSlotChecker();
		System.out.println("overlappedSlots Array(重疊的時段)是否有重疊：" + timeSlotChecker.checkOverlapping(overlappedSlots));
		System.out.println("notOverlappedSlots Array(不重疊的時段)是否有重疊：" + timeSlotChecker.checkOverlapping(notOverlappedSlots));
	}
}