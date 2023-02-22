/* eslint-disable */

import './App.css';
import React from 'react';
import styled from 'styled-components';
import LoginPage from './Pages/LoginPage';
import QuestionPage from './Pages/QuestionPage';
import Header from './components/templates/Header/Header';
import Footer2 from './components/templates/Footer2';
import Sidebar from './components/templates/Sidebar';
import WritePage from './Pages/WritePage';


function App() {
  return (
    <>
      <Header />
      <div className='Container'>
        <WritePage />
      </div>
      <Footer2 />
    </>
  );
}

export default App;
