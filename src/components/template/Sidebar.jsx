import styled, { createGlobalStyle } from "styled-components";
import React, { useEffect, useState } from "react";
import "../../assets/styles/GlobalStyle";
import { Link } from "react-router-dom";

const Sidebar = function () {
  const Sidebar = styled.nav`
  /* border-right: 1px solid rgb(181, 181, 181); */
  
  display: flex;
  flex-direction: column;
  padding-top: 24px;
  margin-left: 100px;
  position: sticky;
  width: 164px;
  z-index: 1;
  height: 100px;
  margin-right: 0px;
    `

  const SidebarUl = styled.ul`
  all: unset;
  flex-direction: column;
  align-items: center;
  box-sizing: border-box;
  color: rgb(81, 81, 81);
  display: flex;
  font-size: small;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen, Ubuntu, Cantarell, "Open Sans",
    "Helvetica Neue", sans-serif;
  height: 34px;
  width: 164px;
  > span {
    cursor: pointer;
  }
  > :hover {
    color: rgb(0, 0, 0);
  }
  &.current-page {
    background-color: rgb(241, 242, 243);
    border-right: 3px solid rgb(244, 130, 36);
  }
  list-style: none;
`

  const SidebarLiPublicLi = styled.ul`
    list-style: none;
    line-height: 2rem;
    margin-top: 10px;
`

  const SidebarList = styled.li`
    cursor: pointer;

    &:active{
        background-color: aliceblue;
        
    }

    `


  return (

    <Sidebar>
      <SidebarUl>
        <Link to={"/"} style={{ textDecoration: 'none' }}>
          <SidebarList className={'selected'} to='/'>Home</SidebarList>
        </Link>
        <SidebarLiPublicLi>
          <Link to={"/"} style={{ textDecoration: 'none' }}>
            <SidebarList className={'selected'} to='/questions'>Questions</SidebarList>
          </Link>
          <SidebarList className={'selected'} to='/tags'>Tags</SidebarList>
        </SidebarLiPublicLi>
      </SidebarUl>
    </Sidebar>

  )
}

export default Sidebar;