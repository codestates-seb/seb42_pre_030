import styled from 'styled-components'
import UserInfo from '../Modules/UserInfo'


const UserInfoMain = function () {

    const Mainpage = styled.div`
    display: flex;
    flex-direction: column;
    width: 60vw;
    justify-content: center;
    margin-top: 0;
`

    return (
        <>
            <Mainpage>
                <UserInfo />
            </Mainpage>
        </>
    )
}

export default UserInfoMain;