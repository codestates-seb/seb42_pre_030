import styled, { createGlobalStyle } from "styled-components";

import Header from '../components/template/Header'
import Sidebar from '../components/template/Sidebar';
import SignUp from '../components/main/SignUp'


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
                <SignUp />
            </MainBar>
        </>
    )
}

export default Login;