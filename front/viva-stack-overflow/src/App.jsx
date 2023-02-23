import './App.css';


import Footer from '../src/Components/Template/Footer';
import AnswerQuestionLoginPage from './Pages/AnswerQuestionLoginPage';
import AnswerQuestionUnloginPage from './Pages/AnswerQuestionUnLoginPage';
import HomeLoginPage from './Pages/HomeLoginPage';
import HomeUnLoginPage from './Pages/HomeUnLoginPage';
import Login from './Pages/Login';
import QuestionSubmitPage from './Pages/QuestionSubmitPage';

import { BrowserRouter, Route, Routes } from 'react-router-dom';
import UserInfo from './Components/Modules/UserInfo';
import SignupForm from './Components/Modules/SignUpForm';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<HomeUnLoginPage />}></Route>
        <Route path='/home' element={<HomeLoginPage />}></Route>
        <Route path='/login' element={<Login />}></Route>
        <Route path='/signup' element={<SignupForm />}></Route>
        <Route path='/mypage' element={<UserInfo />}></Route>
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
