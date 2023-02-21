import styled, { createGlobalStyle } from "styled-components";
import React, { useEffect, useState } from "react";
import "../../assets/styles/variable.css";
import logo_stackoverflow from '../../assets/imgs/--logo--stackoverflow.png'



const Footer = () => {

    const FooterContainer = styled.div`
        width: 100vw;
        display: flex;
        background-color: #35393d;
        padding: 1%;
        padding-right: 1%;
        font-size: 1rem;
        justify-content: center;
    `

    const LogoStackoverflow = styled.img`
        display: flex;
        width: 40px;
    `

    const FooterNav = styled.nav`
        display: flex;
        justify-content: space-evenly;
        width: 100%;
        color: aliceblue;
    `

    const FooterNavList = styled.li`
        padding: 0;
        list-style: none;
        color: rgb(156, 165, 170);
    `

    const FooterNavListItem = styled.li`
        font-size: 0.9rem;
    `

    const FooterCopyright = styled.div`
        display: flex;
        flex-direction: column;
        flex: 1 1 150px;
        margin-left: 1%;
    `

    const FooterSocialUl = styled.ul`
        display: flex;
        justify-content: space-evenly;
        list-style: none;
        margin-top: 20px;
        margin-right: 20px;
        padding: 0;
    `

    const FooterA = styled.a`
        color: var( --bluish-gray-400);
        text-decoration-line: none;
        font-weight: 200;
        font-size: 0.9rem;
        padding-right: 30px;
    `

    const Copyright = styled.p`
        display: flex;
        font-size: 0.7rem;
        color: var( --bluish-gray-400);
        margin-top: 35%;
        padding-right: 10%;
    `

    return (
        <>
            <div className='footer'>
                <FooterContainer>
                    <div className='footer--logo'>
                        <a className='sof--logo' href='https://stackoverflow.com/'><LogoStackoverflow src={logo_stackoverflow}></LogoStackoverflow></a>
                    </div>
                    <FooterNav>
                        <div className='footer-nav-item first'>
                            <h5 className='footer-nav-title first'>STACK OVERFLOW</h5>
                            <FooterNavList className='first'>
                                <FooterNavListItem className='first'>Questions</FooterNavListItem>
                                <FooterNavListItem className='first'>Help</FooterNavListItem>
                            </FooterNavList>
                        </div>
                        <div className='footer-nav-item second'>
                            <h5 className='footer-nav-title second'>PRODUCTS</h5>
                            <FooterNavList className='second'>
                                <FooterNavListItem className='second'>Teams</FooterNavListItem>
                                <FooterNavListItem className='second'>Advertising</FooterNavListItem>
                                <FooterNavListItem className='second'>Collectives</FooterNavListItem>
                                <FooterNavListItem className='second'>Talent</FooterNavListItem>
                            </FooterNavList>
                        </div>
                        <div className='footer-nav-item third'>
                            <h5 className='footer-nav-title third'>COMPANY</h5>
                            <FooterNavList className='third'>
                                <FooterNavListItem className='third'>About</FooterNavListItem>
                                <FooterNavListItem className='third'>Press</FooterNavListItem>
                                <FooterNavListItem className='third'>Work Here</FooterNavListItem>
                                <FooterNavListItem className='third'>Legal</FooterNavListItem>
                                <FooterNavListItem className='third'>Priivacy Policy</FooterNavListItem>
                                <FooterNavListItem className='third'>Terms of Service</FooterNavListItem>
                                <FooterNavListItem className='third'>Contact Us</FooterNavListItem>
                                <FooterNavListItem className='third'>Coolie Settings</FooterNavListItem>
                                <FooterNavListItem className='third'>Cookie Policy</FooterNavListItem>
                            </FooterNavList>
                        </div>
                        <div className='footer-nav-item fourth'>
                            <h5 className='footer-nav-title fourth'>STACK EXCHANGE NETWORK</h5>
                            <FooterNavList className='fourth'>
                                <FooterNavListItem className='fourth'>Technology</FooterNavListItem>
                                <FooterNavListItem className='fourth'>Culture & recreation</FooterNavListItem>
                                <FooterNavListItem className='fourth'>Life & arts</FooterNavListItem>
                                <FooterNavListItem className='fourth'>Science</FooterNavListItem>
                                <FooterNavListItem className='fourth'>Professional</FooterNavListItem>
                                <FooterNavListItem className='fourth'>Business</FooterNavListItem>
                                <br />
                                <FooterNavListItem className='fourth'>API</FooterNavListItem>
                                <FooterNavListItem className='fourth'>DATA</FooterNavListItem>
                            </FooterNavList>
                        </div>
                    </FooterNav>
                    <FooterCopyright>
                        <FooterSocialUl>
                            <li className='footer--social--li blog'><FooterA href='https://stackoverflow.blog?blb=1'>Blog</FooterA></li>
                            <li className='footer--social--li twitter'><FooterA href='https://twitter.com/stackoverflow'>Twitter</FooterA></li>
                            <li className='footer--social--li facebook'><FooterA href='https://www.facebook.com/officialstackoverflow/'>Facebook</FooterA></li>
                            <li className='footer--social--li linkedin'><FooterA href='https://www.linkedin.com/company/stack-overflow'>LinkedIn</FooterA></li>
                            <li className='footer--social--li instagram'><FooterA href='https://www.instagram.com/thestackoverflow'>Instagram</FooterA></li>
                        </FooterSocialUl>
                        <Copyright>Site design / logo © 2023 Stack Exchange Inc; user contributions licensed under CC BY-SA. rev 2023.2.17.43248</Copyright>
                    </FooterCopyright>
                </FooterContainer>
            </div>
        </>

    )
}

export default Footer;