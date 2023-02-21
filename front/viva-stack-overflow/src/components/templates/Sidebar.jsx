import styled, { createGlobalStyle } from "styled-components";
import React, { useEffect, useState } from "react";
import "../../assets/styles/variable.css";

const Sidebar = function () {
    const Sidebar = styled.div`
        transition: box-shadow ease-in-out .1s,transform ease-in-out .1s;
        position: absolute;
        top: 70px;
        margin-left: 17%;
    `

    const SidebarUl = styled.ul`
    list-style: none;
    line-height: 2rem;
`

    const SidebarLiPublicLi = styled.ul`
    list-style: none;
    line-height: 2rem;
`

    const SidebarList = styled.li`
    cursor: pointer;

    `

    return (
        <>
            <Sidebar>
                <SidebarUl>
                    <SidebarList className={({ isActive }) => 'SidebarList' + (isActive ? "a" : "")} to='/'>Home</SidebarList>
                    <SidebarLiPublicLi>
                        <SidebarList className={({ isActive }) => 'SidebarList' + (isActive ? "a" : "")} to='/questions'>Questions</SidebarList>
                        <SidebarList className={({ isActive }) => 'SidebarList' + (isActive ? "a" : "")} to='/tags'>Tags</SidebarList>
                    </SidebarLiPublicLi>
                </SidebarUl>
            </Sidebar>
        </>
    )
}

export default Sidebar;