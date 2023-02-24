import styled from 'styled-components'
import SignupForm from '../Modules/SignupForm'


const SignUp = function () {

    const SignUpContainer = styled.div`
    display: flex;
    flex-wrap: wrap;
    width: 840px;
    padding: 100px;
    height: 100vh;
    `

    return (
        <>
            <SignUpContainer>
                <SignupForm />
            </SignUpContainer>
        </>
    )
}

export default SignUp;