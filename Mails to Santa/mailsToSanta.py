from datetime import datetime, timedelta

from mails_to_santa.holidays import HOLIDAY_LIST


class MailsToSanta:
    @staticmethod
    def calculated_time_to_process(time_of_arrival: datetime.datetime) -> datetime.datetime:
        time_of_arrival = MailsToSanta.calculate_business_hours(time_of_arrival)
        time_of_arrival = MailsToSanta.calculate_work_days(time_of_arrival)
        time_of_arrival = MailsToSanta.calculate_holidays(time_of_arrival)

        return time_of_arrival

    @staticmethod
    def calculate_business_hours(time_of_arrival: datetime.datetime) -> datetime.datetime:
        hours = time_of_arrival.hour

        if hours < 8 or hours > 15:
            time_of_arrival = time_of_arrival.replace(hour=8, minute=0)

        if hours > 15:
            time_of_arrival = time_of_arrival + timedelta(days=1)

        return time_of_arrival

    @staticmethod
    def calculate_work_days(time_of_arrival: datetime.datetime) -> datetime.datetime:
        weekday = time_of_arrival.weekday()

        if weekday > 4:
            daydelta = 7-weekday
            new_datetime = timedelta(days=daydelta)
            time_of_arrival = time_of_arrival + new_datetime
            time_of_arrival = time_of_arrival.replace(hour=8, minute=0)

        return time_of_arrival

    @staticmethod
    def calculate_holidays(time_of_arrival: datetime.datetime) -> datetime.datetime:

        for holiday in HOLIDAY_LIST:
            day = time_of_arrival.day
            month = time_of_arrival.month
            year = time_of_arrival.year

            if month >= holiday['start']['month'] and month <= holiday['end']['month'] and day >= holiday['start']['day'] and day <= holiday['end']['day']:
                time_of_arrival = time_of_arrival.replace(year=year, month=holiday['end']['month'], day=holiday['end']['day'], hour=8, minute=0)

                new_date = timedelta(days=1)
                time_of_arrival = time_of_arrival + new_date

        return time_of_arrival