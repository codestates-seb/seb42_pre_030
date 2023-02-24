import './App.css';


import Footer from '../src/Components/Template/Footer';
import AnswerQuestionLoginPage from './Pages/AnswerQuestionLoginPage';
import AnswerQuestionUnloginPage from './Pages/AnswerQuestionUnLoginPage';
import HomeLoginPage from './Pages/HomeLoginPage';
import HomeUnLoginPage from './Pages/HomeUnLoginPage';
import Login from './Pages/Login';
import SignUp from './Pages/SignUp';
import QuestionSubmitPage from './Pages/QuestionSubmitPage';

import { BrowserRouter, Route, Routes } from 'react-router-dom';
import UserInfoPage from './Pages/UserInfoPage';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<HomeUnLoginPage />}></Route>
        <Route path='/home' element={<HomeLoginPage />}></Route>
        <Route path='/login' element={<Login />}></Route>
        <Route path='/signup' element={<SignUp />}></Route>
        <Route path='/mypage' element={<UserInfoPage />}></Route>
        <Route path='/mypage/edit' ></Route>
        <Route path='/questionsubmit' element={<QuestionSubmitPage />}></Route>
        <Route path='/answerquestion' element={<AnswerQuestionLoginPage />}></Route>
        <Route path='/answerquestion/login' element={<AnswerQuestionUnloginPage />}></Route>
      </Routes>
      <Footer />
    </BrowserRouter>
  );
}

export default App;
