package kz.lesson12;

import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Chronology;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster.*;
import java.util.Locale;
import java.util.TimeZone;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.nextOrSame;

public class TestLocalDateTimeDemo {
    public static void main(String[] args) {
        localDate();
    }

    private static void localDate() {
        //2017-09-21
        LocalDate localDate = LocalDate.of(2017, 9, 21);
        //2017
        int year = localDate.getYear();
        //September
        Month month = localDate.getMonth();
        //21
        int dayOfMonth = localDate.getDayOfMonth();
        //THursday
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        //30 дней в сентябре
        int i = localDate.lengthOfMonth();
        //false год не високосный
        boolean leapYear = localDate.isLeapYear();

        //Чтение значений LocalDate с помощью TemporalField
        int i1 = localDate.get(ChronoField.YEAR);
        int i2 = localDate.get(ChronoField.MONTH_OF_YEAR);
        int i3 = localDate.get(ChronoField.DAY_OF_WEEK);


        int year1 = localDate.getYear();
        int monthValue = localDate.getMonthValue();
        DayOfWeek dayOfWeek1 = localDate.getDayOfWeek();

    }

    private static void localTime() {
        //13:45:20
        LocalTime localTime = LocalTime.of(13, 45, 20);
        //13
        int hour = localTime.getHour();
        int minute = localTime.getMinute();
        int second = localTime.getSecond();
    }

    private static void createDate() {
        LocalDate parse = LocalDate.parse("2017-09-21");
        LocalTime parse1 = LocalTime.parse("13:45:20");
    }

    private static void localDateTime() {
        LocalDate date = LocalDate.of(2017, 9, 21);
        LocalTime time = LocalTime.of(13, 45, 20);
        LocalDateTime dt1 = LocalDateTime.of(2017, Month.SEPTEMBER, 21, 13, 45, 20);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(13, 45, 20);
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);


        LocalDate localDate = dt1.toLocalDate();
        LocalTime localTime = dt1.toLocalTime();

    }

    private static void instant() {
        Instant i1 = Instant.ofEpochSecond(3);
        Instant i2 = Instant.ofEpochSecond(3, 0);
        Instant i3 = Instant.ofEpochSecond(2, 1_000_000_000);
        Instant i4 = Instant.ofEpochSecond(4, -1_000_000_000);


        LocalDate date = LocalDate.of(2017, 9, 21);
        LocalDate date2 = LocalDate.of(2017, 9, 21);
        LocalTime time = LocalTime.of(13, 45, 20);
        LocalTime time2 = LocalTime.of(13, 45, 20);

        //exception
        Instant.now().get(ChronoField.DAY_OF_MONTH);

        /**
         * Поскольку классы LocalDateTime и Instant предназначены для различных целей
         * (один для применения людьми, а второй — машинами), то смешивать их нельзя.
         * Более того, поскольку класс Duration отражает время, изме-
         * ряемое в секундах и наносекундах, то передавать LocalDate в объект between нельзя.
         */
        Duration.between(date, date2);
        Duration.between(time, time2);
        Duration.between(i2, i3);

        Period.between(date, date2);
    }

    private static void createDurationAndPeriod() {
        Duration threeMinutes = Duration.ofMinutes(3);
//        Duration threeMinutes2 = Duration.ofMinutes(3, ChronoUnit.MINUTES);
        Period.ofDays(10);
        Period.ofWeeks(3);
        Period.of(2, 6, 1);
    }

    private static void dateWith() {
        LocalDate date = LocalDate.of(2017, 9, 21);
        //2011-09-21
        LocalDate date1 = date.withYear(2011);
        //2011-09-25
        LocalDate date2 = date1.withDayOfMonth(25);
        //2011-02-25
        LocalDate date3 = date2.with(ChronoField.MONTH_OF_YEAR, 2);

        LocalDate date4 = date.plusWeeks(1);
        LocalDate date5 = date4.plusYears(6);
        date5.plus(6, ChronoUnit.MONTHS);
    }

    private static void temporalAdjuster() {
        LocalDate date = LocalDate.of(2017, 9, 21);
        LocalDate date1 = date.with(nextOrSame(DayOfWeek.SUNDAY));//2014-03-18
        date1.with(lastDayOfMonth()); //2014-03-31
    }

    private static void dateTimeFormatter() {
        LocalDate date = LocalDate.of(2017, 9, 21);
        date.format(DateTimeFormatter.ISO_LOCAL_DATE);//2014-03-18
        date.format(DateTimeFormatter.BASIC_ISO_DATE);//20140318

        LocalDate.parse("2014-03-18", DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate.parse("20140318", DateTimeFormatter.BASIC_ISO_DATE);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.of(2014, 3, 18);
        String format = localDate.format(dateTimeFormatter);
        LocalDate parse = LocalDate.parse(format, dateTimeFormatter);


        /**
         * Создание локализованного DateTimeFormatter
         */

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
        LocalDate localDate1 = LocalDate.of(2014, 3, 18);
        String format1 = localDate1.format(formatter);
        LocalDate parse1 = LocalDate.parse(format1, formatter);

    }

    private static void zoneTime() {
        ZoneId romeZone = ZoneId.of("Europe/Rome");
        ZoneId zoneId1 = TimeZone.getDefault().toZoneId();

        LocalDate date = LocalDate.of(2014, Month.APRIL, 18);
        ZonedDateTime zonedDateTime = date.atStartOfDay(romeZone);
        LocalDateTime dt1 = LocalDateTime.of(2017, Month.SEPTEMBER, 21, 13, 45, 20);
        ZonedDateTime zonedDateTime1 = dt1.atZone(romeZone);
        Instant now = Instant.now();
        ZonedDateTime zonedDateTime2 = now.atZone(romeZone);

        /**
         * Смещение -05:00
         */
        ZoneOffset newYorkOffset = ZoneOffset.of("-50:00");
        OffsetDateTime offsetDateTime = OffsetDateTime.of(dt1, newYorkOffset);
        JapaneseDate japaneseDate = JapaneseDate.from(date);
        Chronology chronology = Chronology.ofLocale(Locale.JAPAN);
        ChronoLocalDate chronoLocalDate = chronology.dateNow();


    }










}
