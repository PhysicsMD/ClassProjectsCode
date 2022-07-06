import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import ReactHeader from './ReactHeader';
import Pane from './Pane';


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <><ReactHeader />
  <Pane title='Declarative' content='React makes it painless to create interactive UIs. Design simple views for each state in your application, and React will efficiently update and render just the right components when your data changes.' />
  <Pane title='Component-based' content='Build encapsulated components that manage their own state, then compose them to make complex UIs. Since component logic is written in JavaScript instead of templates, you can easily pass rich data through your app and keep state out of the DOM.' />
  <Pane title='Learn Once, Write Anywhere' content="We don't make assumptions about the rest of your technology stack, so you can develop new features in React without rewriting existing code. React can also render on the server using Node and power mobile apps using React Native." />
  </>
);
