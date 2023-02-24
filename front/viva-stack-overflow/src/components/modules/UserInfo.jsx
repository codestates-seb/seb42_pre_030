import styled, { createGlobalStyle } from "styled-components"
import React from "react";
import "../../Assets/STYLES/variable.css";
import * as LoginForm from '../Modules/LoginForm';
import icon_cake from "../../Assets/IMGS/--icon--gray--cake.png";
import icon_clock from "../../Assets/IMGS/--icon--gray--clock.png";
import icon_calendar from "../../Assets/IMGS/--icon--gray--calendar.png";



const Main = styled.div`
    display: flex;
    justify-content: center;
    align-items: center;
    width: 70vw;
    height: 120vh;
    padding:24px;
    display: flex;
    justify-content: center;

`;
const Section = styled.div`
    
`;
const Components = styled.div`
    display: flex;
    flex-direction: column;
    justify-content: center;
    flex: 1;
`;

const Info = styled.div`
    display: flex;
`;
const Navigatiion = styled.div`
    display: flex;
    padding:20px 0;
`;
const ContentProfile = styled.div`
    flex:1;
`;
const ContentActivity = styled.div`
    flex:1;
`;
const ContentSettings = styled.div`
    flex:1;
`;
const Format = (props) => {
    return (
        <>
            <TitleCss>{props.title}</TitleCss>
            <BoxCss></BoxCss>
        </>
    )
}
const TitleCss = styled.div`
    font-size: 30px;
    color:var(--gray-500);
    margin-bottom: 8px;
`;
const BoxCss = styled.div`
    height: 55px;
    border: 1px solid #dbdbdb;
    border-radius: 3px;
    margin-bottom: 30px;
`;


const InfoL = styled.div`
    width:128px;
    height:128px;
    border-radius: 5px;
    background-color: var( --bluish-gray-400);
    color: white;
    font-weight: 400;
    font-size: 50px;
    display: flex;
    justify-content: center;
    align-items: center;
    margin-right: 30px;
`;
const InfoM = styled.div`
    flex:4;
    display: flex;
    flex-direction: column;
    justify-content: center;
`;
const InfoR = styled.div`
    flex: 1;
`;

const Username = styled.div`
    margin-bottom: 8px;
    font-size: 40px;
    font-weight:300;
`;
const UserDate = styled.div`
    display: flex;
`;
const Item = styled.div`
    display: flex;
    align-items:center;
    justify-content: center;
    color:#6a737c;
`;
const ItemIcon = ({ href, text }) => {
    return (
        <Item>
            <img src={href} alt="아이콘" width="18px" ></img>
            <span style={{ marginRight: 15, marginLeft: 5, }}>{text}</span>
        </Item>
    )
}
const MenuDiv = (props) => {
    return <MenuCss>{props.text}</MenuCss>

}
const MenuCss = styled.div`
    padding:6px 12px;
    color:#525960;
    font-size: 18px;
`;

const UserInfo = () => {
    return (
        <>
            <Main>
                <Section>
                    <Components>
                        <Info>
                            <InfoL>이름</InfoL>
                            <InfoM>
                                <Username>성이름</Username>
                                <UserDate>
                                    <ItemIcon href={icon_cake} text="Member for 8 days"></ItemIcon>
                                    <ItemIcon href={icon_clock} text="Last seen this week"></ItemIcon>
                                    <ItemIcon href={icon_calendar} text="Visited 4 days, 1 consecutive"></ItemIcon>
                                </UserDate>
                            </InfoM>
                        </Info>
                        <Navigatiion>
                            <MenuDiv text="Profile" />
                            <MenuDiv text="Activity" />
                            <MenuDiv text="Settings" />
                        </Navigatiion>
                        <ContentProfile>
                            <Format title="Stats" />
                            <Format title="About" />
                            <Format title="Badges" />
                            <Format title="Posts" />
                            <Format title="Communities" />
                        </ContentProfile>
                    </Components>
                </Section>
            </Main>
        </>
    )
}

export default UserInfo