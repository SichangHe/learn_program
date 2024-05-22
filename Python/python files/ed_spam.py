#!/usr/bin/env python

import pyautogui
from time import sleep


def click(x, y, w, z):
    pyautogui.click(x, y, duration=0.1)
    pyautogui.click(w, z, duration=0.1)


def click_and_refresh(x, y, w, z):
    for _ in range(70):
        click(x, y, w, z)
    pyautogui.hotkey("command", "r")
    sleep(1)


print(
    "use x,y=pyautogui.position() and w,z=pyautogui.position() to record the two points and use click_and_refresh(x,y,w,z) to click them and refresh, and put them in a loop."
)
