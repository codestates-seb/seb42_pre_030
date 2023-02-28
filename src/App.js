import './App.css';

import Footer from './components/template/Footer';
import AnswerQuestionLoginPage from './Pages/AnswerQuestionLoginPage';
import AnswerQuestionUnloginPage from './Pages/AnswerQuestionUnLoginPage';
import HomeLoginPage from './Pages/HomeLoginPage';
import HomeUnLoginPage from './Pages/HomeUnLoginPage';
import LoginPage from './Pages/LoginPage';
import SignUpPage from './Pages/SignUpPage';
import QuestionSubmitPage from './Pages/QuestionSubmitPage';

import { BrowserRouter, Route, Routes } from 'react-router-dom';
import UserInfoPage from './Pages/UserInfoPage';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<HomeUnLoginPage />} />
        <Route path='/home' element={<HomeLoginPage />}></Route>
        <Route path='/login' element={<LoginPage />}></Route>
        <Route path='/signup' element={<SignUpPage />}></Route>
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
