import styled, { createGlobalStyle } from "styled-components";

import Header from '../components/template/Header'
import Sidebar from '../components/template/Sidebar';
import LoginForm from "../components/modules/LoginForm";


const Login = function () {

    const MainBar = styled.div`
    display: flex;
    flex-direction: row;
    width: 500px;
    
`

    return (
        <>
            <Header />
            <MainBar>
                <Sidebar />
                <LoginForm />
            </MainBar>
        </>
    )
}

export default Login;