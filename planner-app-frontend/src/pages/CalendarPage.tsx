import React, { useState, useEffect } from 'react';
import Calendar from 'react-calendar';
import 'react-calendar/dist/Calendar.css';
import { Value } from 'react-calendar/dist/cjs/shared/types';

interface Event {
  id: number;
  title: string;
  description: string;
  date: string;
}

const CalendarPage: React.FC = () => {
  const [events, setEvents] = useState<Event[]>([]);
  const [selectedDate, setSelectedDate] = useState(new Date());

  useEffect(() => {
    fetchEvents(selectedDate);
  }, [selectedDate]);

  const fetchEvents = async (date: Date) => {
    const dateString = date.toISOString().slice(0, 10);
    const response = await fetch('/api/events/get-by-month', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ date: dateString })
    });
    const data = await response.json();
    setEvents(data);
  };

  const handleDateChange = (date: Date) => {
    setSelectedDate(date);
  };

  const handleCalendarChange = (value: Value, event: React.MouseEvent<HTMLButtonElement>) => {
    if (value instanceof Array) {
        const [start] = value;
        if (start instanceof Date) {
            handleDateChange(start);
        }
    };
  };

  const handleEventClick = (event: Event) => {
    alert(`Selected event: ${event.title}`);
  };

  return (
    <div className="dashboard">
      <div className="calendar">
        <Calendar onChange={handleCalendarChange} value={selectedDate} />
      </div>
      <div className="event-list">
        <h2>Events for {selectedDate.toLocaleDateString()}</h2>
        {events.length > 0 ? (
          <ul>
            {events.map((event) => (
              <li key={event.id} onClick={() => handleEventClick(event)}>
                <strong>{event.title}</strong>
                <br />
                {event.description}
              </li>
            ))}
          </ul>
        ) : (
          <p>No events found for this month</p>
        )}
      </div>
    </div>
  );
};

export default CalendarPage;