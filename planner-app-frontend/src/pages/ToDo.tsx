import React, { useState } from 'react';

interface Task {
  id: number;
  title: string;
  description: string;
  date: string;
}

const ToDo: React.FC = () => {
  const [toDoList, setToDoList] = useState<Task[]>([]);
  const [doingList, setDoingList] = useState<Task[]>([]);
  const [doneList, setDoneList] = useState<Task[]>([]);
  const [idCounter, setIdCounter] = useState<number>(0);

  const handleAddToDoItem = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    // const itemText = event.currentTarget.elements.newToDoItem.value;
    // if (itemText) {
    //   const newTask: Task = {
    //     id: idCounter,
    //     title: itemText,
    //     description: '',
    //     date: '',
    //   };
    //   setToDoList([...toDoList, newTask]);
    //   setIdCounter(idCounter + 1);
    //   event.currentTarget.reset();
    // }
  };

  const handleMoveToDoing = (itemIndex: number) => {
    const item = toDoList[itemIndex];
    setToDoList(toDoList.filter((_, index) => index !== itemIndex));
    setDoingList([...doingList, item]);
  };

  const handleMoveToDone = (itemIndex: number) => {
    const item = doingList[itemIndex];
    setDoingList(doingList.filter((_, index) => index !== itemIndex));
    setDoneList([...doneList, item]);
  };

  return (
    <div className="App">
      <h1>To-Do List</h1>
      <div className="lists-container">
        <div className="list">
          <h2>To Do</h2>
          <form onSubmit={handleAddToDoItem}>
            <input type="text" name="newToDoItem" placeholder="Add a new item" />
            <button type="submit">Add</button>
          </form>
          <ul>
            {toDoList.map((item) => (
              <li key={item.id}>
                <div>{item.title}</div>
                <button onClick={() => handleMoveToDoing(toDoList.indexOf(item))}>Move to Doing</button>
              </li>
            ))}
          </ul>
        </div>
        <div className="list">
          <h2>Doing</h2>
          <ul>
            {doingList.map((item) => (
              <li key={item.id}>
                <div>{item.title}</div>
                <button onClick={() => handleMoveToDone(doingList.indexOf(item))}>Move to Done</button>
              </li>
            ))}
          </ul>
        </div>
        <div className="list">
          <h2>Done</h2>
          <ul>
            {doneList.map((item) => (
              <li key={item.id}>
                <div>{item.title}</div>
              </li>
            ))}
          </ul>
        </div>
      </div>
    </div>
  );
};

export default ToDo;
