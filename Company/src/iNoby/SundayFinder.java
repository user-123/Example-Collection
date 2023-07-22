package iNoby;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SundayFinder {

	public SundayFinder() {}

	public static void main(String[] args) {
		LocalDate startDate = LocalDate.of(2021, 8, 1);
		LocalDate endDate = LocalDate.of(2021, 8, 31);
		SundayFinder sundayFinder = new SundayFinder();
		List<LocalDate> sundaysInRange = sundayFinder.findSundaysInRange(startDate, endDate);
		System.out.println(sundaysInRange);
		for (LocalDate sunday : sundaysInRange) {
			System.out.println(sunday);
		}
	}

	public List<LocalDate> findSundaysInRange(LocalDate startDate, LocalDate endDate) {
		List<LocalDate> sundaysInRange = new ArrayList<>();
		LocalDate sunday = startDate.with(DayOfWeek.SUNDAY);
		if (!sunday.isAfter(startDate)) {	//依照例子，startDate若為星期日，該日不列入計算；若要列入計算，條件改為sunday.isBefore(startDate)
			sunday = sunday.plusWeeks(1);
		}
		while (sunday.isBefore(endDate)) {	//推測需求，EndDate若為星期日，則該日不列入計算；若要列入計算，條件改為!sunday.isAfter(endDate)
			sundaysInRange.add(sunday);
			sunday = sunday.plusWeeks(1);
		}
		return sundaysInRange;
	}

}
