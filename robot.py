import keyboard
import mouse
import math

x_remainder = 0
y_remainder = 0

mouse_button_dict = {
    'MouseButton.left': mouse.LEFT,
    'MouseButton.right': mouse.RIGHT
}


def move_cursor_to(x, y):
    # print(f"moving mouse to {x} {y}")

    global x_remainder
    global y_remainder

    # if x < 1:
    # x = math.ceil(x)

    # if y < 1:
    # y = math.ceil(y)

    x = x*2.5 + x_remainder
    y = y*2.5 + y_remainder

    # # print(math.modf(x))
    # # print(math.modf(y))

    x_remainder, x = math.modf(x)
    y_remainder, y = math.modf(y)

    mouse.move(x, y, absolute=False)


def mouse_button(mouse_button, event_type):
    # print(mouse_button, event_type)
    if event_type == "EventActionType.down":
        mouse.press(mouse_button_dict[mouse_button])

    if event_type == "EventActionType.up":
        mouse.release(mouse_button_dict[mouse_button])


def type_text(text):
    keyboard.write(text)
