import React from 'react';
import { Link } from 'react-router-dom';


const DefaultNavbar: React.FC = () => {
    return (
        <nav className="navbar">
          <ul>
            <li>
              <Link to="/">Home</Link>
            </li>
            <li>
              <Link to="/todo">To-Do List</Link>
            </li>
            <li>
              <Link to="/calendar">Calendar</Link>
            </li>
          </ul>
        </nav>
    );
};

export default DefaultNavbar;