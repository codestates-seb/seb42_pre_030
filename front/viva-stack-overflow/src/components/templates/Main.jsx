import styled, { isStyledComponent } from "styled-components"


const Main = () => {

    const Mainpage = styled.div`
    display: flex;
width: 50vw;
height: 100vh;
font-size: 100px;
background-color: aqua;
margin-left: 35vw;
padding-top: 10vh;
justify-content: center;
`

    return (
        <>
            <Mainpage>good</Mainpage>
        </>
    )

}

export default Main