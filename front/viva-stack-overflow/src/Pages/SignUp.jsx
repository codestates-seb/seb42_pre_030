import styled, { createGlobalStyle } from "styled-components";

import Header from '../Components/Template/Header'
import Sidebar from '../Components/Template/Sidebar';
import SignUp from '../Components/Mains/SignUp'


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