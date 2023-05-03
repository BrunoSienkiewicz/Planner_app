import React from 'react';
import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import HomePage from './pages/HomePage';
import CalendarPage from './pages/CalendarPage';
import ToDo from './pages/ToDo';
import DefaultNavbar from './navbar/defaultNavbar';

function App() {
  return (
    <Router>
      <div>
        <DefaultNavbar />

        <Routes>
          <Route path="/todo" element={<ToDo/>} />
          <Route path="/calendar" element={<CalendarPage/>} />
          <Route path="/" element={<HomePage/>} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
