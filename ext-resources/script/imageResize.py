import os, sys
from PIL import Image

size_large = 512, 512
size_medium = 256, 256
size_small = 127, 127


def convert_from_dir(directory):
    for i, filename in enumerate(os.listdir(directory)):
        print(filename.lower())
        if filename.lower().endswith('.png') or filename.lower().endswith('.jpg'):
            if not os.path.exists(directory + '_out'):
                os.makedirs(directory + '_out')
            outfile = directory + '_out/%d.jpg' % i
            im = Image.open(directory + '/' + filename)
            im = im.convert('RGB')
            im = pad2SquareWithWhite(im)
            im.thumbnail(size_small)
            im.save(outfile, 'JPEG')


def pad2SquareWithBlack(image):
    longer_side = max(image.size)
    horizontal_padding = (longer_side - image.size[0]) / 2
    vertical_padding = (longer_side - image.size[1]) / 2
    im = image.crop(
        (
            -horizontal_padding,
            -vertical_padding,
            image.size[0] + horizontal_padding,
            image.size[1] + vertical_padding
        )
    )
    return im

def pad2SquareWithWhite(image):
    edge = max(image.size)
    blank_image = Image.new('RGB', (edge, edge), 'white')
    position = ((blank_image.width - image.width)//2, (blank_image.height - image.height)//2)
    blank_image.paste(image, position)
    return blank_image

# two other ways to resize image
# square_image = ImageOps.fit(im, size_small, Image.ANTIALIAS)
# im = im.resize(size_small)

if __name__ == '__main__':
    convert_from_dir(sys.argv[1])
