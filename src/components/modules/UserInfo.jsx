import styled, { createGlobalStyle } from "styled-components"
import React, { useEffect } from "react";
import "../../assets/styles/variable.css";
import * as SignupForm from './SignupForm';
import icon_cake from "../../assets/IMGS/--icon--gray--cake.png";
import icon_clock from "../../assets/IMGS/--icon--gray--clock.png";
import icon_calendar from "../../assets/IMGS/--icon--gray--calendar.png";
import icon_setting from "../../assets/IMG/--icon--setting.png";
import axios from "axios";


const Main = styled.div`
    /* width: 70vw; */
    /* height: 130vh; */
    padding:24px;
    display: flex;
    align-items: center;
    justify-content: center;
    border-left:1px solid rgb(181, 181, 181);
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

const Format = (props) => {
    return (
        <>
            <TitleCss>{props.title}</TitleCss>
            <BoxCss></BoxCss>
        </>
    )
}
const TitleCss = styled.div`
    font-size: 20px;
    color:var(--gray-500);
    margin-bottom: 8px;
`;
const BoxCss = styled.div`
    height: 55px;
    border: 1px solid #dbdbdb;
    border-radius: 3px;
    margin-bottom: 30px;
`;
const BoxCss3 = styled.div`
    height: 260px;
    width: 252px;
    border: 1px solid #dbdbdb;
    border-radius: 3px;
    margin:5px;
    padding:12px;
    margin-bottom: 30px;
    display: flex;
    flex-direction: column;
    align-items: center;
`;
const BoxCss2 = styled.div`
    height: 55px;
    border: 1px solid #dbdbdb;
    border-radius: 3px;
    margin-bottom: 30px;
`;

const InfoL = styled.div`
    width:128px;
    height:128px;
    border-radius: 5px;
    background-color: #6c929b;
    color: white;
    font-weight: 400;
    font-size: 50px;
    display: flex;
    justify-content: center;
    align-items: center;
    margin-right: 20px;
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
    font-size: 30px;
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
            <img src={href} alt="아이콘" width="15px" ></img>
            <span style={{ marginRight: 10, marginLeft: 5 }}>{text}</span>
        </Item>
    )
}
const MenuDiv = (props) => {
    return <MenuCss>{props.text}</MenuCss>

}
const MenuCss = styled.div`
    padding:6px 12px;
    color:#525960;
    font-size: 15px;
`;
const Flex = styled.div`
    display: flex;
`;
const UserInfo = () => {
    const URI = "http://ec2-3-35-220-165.ap-northeast-2.compute.amazonaws.com:8080";
    // const URI = "https://af9b-39-121-143-132.jp.ngrok.io";
    useEffect(() => {
        console.log(sessionStorage.getItem("Authorization"));
        // axios.defaults.headers.common["Authorization"]=sessionStorage.getItem("Authorization")
        (async () => {
            await axios({
                method: 'get',
                // url: `/members`,
                url: `${URI}/members/get`,
                params: {},
                headers: {
                    Authorization: sessionStorage.getItem("Authorization")
                }
            }, { withCredentials: true })

                .then((res) => {
                    console.log(res)

                })
                .catch((err) => { console.log(err) })
        })()
    }, [])
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
                                    <ItemIcon href={icon_cake} text="Member for N days"></ItemIcon>
                                    <ItemIcon href={icon_clock} text="Last seen this week"></ItemIcon>
                                    <ItemIcon href={icon_calendar} text="Visited N days, N consecutive"></ItemIcon>
                                </UserDate>
                            </InfoM>
                        </Info>
                        <Navigatiion>
                            <MenuDiv text="Profile" />
                            <MenuDiv text="Activity" />
                            <MenuDiv text="Settings" />
                        </Navigatiion>
                        <ContentProfile>
                            <TitleCss>Summary</TitleCss>
                            <Flex>
                                <BoxCss3>
                                    <img src={icon_setting} style={{ width: '40px', justifySelf: 'center', marginTop: '30px', marginBottom: '10px' }} alt="ddd"></img>
                                    <div style={{ fontSize: '15px', textAlign: 'center', marginBottom: '10px' }}>Reputation is how the community thanks you</div>
                                    <div style={{ fontSize: '11px', textAlign: 'center' }}>When users upvote your helpful posts, you'll earn reputation and unlock new privileges.</div>
                                </BoxCss3>
                                <BoxCss3>
                                    <img src={icon_setting} style={{ width: '40px', justifySelf: 'center', marginTop: '30px', marginBottom: '10px' }} alt="ddd"></img>
                                    <div style={{ fontSize: '15px', textAlign: 'center', marginBottom: '10px' }}>Earn badges for helpful actions</div>
                                    <div style={{ fontSize: '11px', textAlign: 'center' }}>Badges are bits of digital flair that you get when you participate in especially helpful ways.</div>
                                <SignupForm.Btn style={{marginTop:'30px', width:'250px'}}>Take the Tour and earn your first badge</SignupForm.Btn>
                                </BoxCss3>
                                <BoxCss3>
                                    <img src={icon_setting} style={{ width: '40px', justifySelf: 'center', marginTop: '30px', marginBottom: '10px' }} alt="ddd"></img>
                                    <div style={{ fontSize: '15px', textAlign: 'center', marginBottom: '10px' }}>Measure your impact</div>
                                    <div style={{ fontSize: '11px', textAlign: 'center' }}>Your posts and helpful actions here help hundreds or thousands of people searching for help.</div>
                                </BoxCss3>
                            </Flex>
                            <Format title="Answers" />
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